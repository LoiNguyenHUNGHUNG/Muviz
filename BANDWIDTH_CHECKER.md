# Bandwidth checker case study

This branch adds trusted network contracts for analysis with the
[`bandwidth-timeout-checker`](https://github.com/LoiNguyenHUNGHUNG/bandwidth-timeout-checker).

## Assumptions and runtime bounds

- Each TMDB endpoint is annotated as a primitive download. The current
  5,000,000-byte response bound is a case-study assumption, not a measured API
  guarantee. Replace it with a justified endpoint-specific bound before making
  a production guarantee.
- The TMDB OkHttp client has a 15-second whole-call timeout and permits at most
  five simultaneous requests.
- The Coil image client also permits at most five simultaneous requests. It has
  no whole-call timeout, so its required bandwidth rate is zero in the
  checker's model; its requests can still be concurrent and long-lived.
- `@BoundedClient` and `@BandwidthEffect` are trusted descriptions of those
  runtime library boundaries.

## Run the analysis

The checker is a Kotlin compiler plugin, so compiling the selected source is
the analysis. Check out the checker and this Muviz branch, then run from the
Muviz repository:

```shell
./gradlew :app:compileDebugKotlin \
  -PbandwidthCheckerPath=/absolute/path/to/bandwidth-timeout-checker \
  -PkotlinVersion=2.2.20
```

Use JDK 21 or newer and set `ANDROID_HOME` if the Android SDK is not already
configured. The composite build loads the local checker and its annotation
module; nothing needs to be published first.

The configured entry point is
`FilmDetailsViewModel.getFilmDetails`. The checker follows calls from that
function into the repositories and annotated Retrofit endpoints. With
`reportEffects` enabled, Gradle prints the inferred effect and required
bandwidth. A rejected bound is reported as a compiler error and fails the
build.

At present, this workflow reports `(333334, 20)` and a required bandwidth of
6,666,680 bytes per second. This is safe but coarse: the checker treats the
four possible TMDB endpoint kinds as independently bounded by five, whereas
the shared runtime dispatcher admits only five TMDB requests in total. Using
the client-wide capacity directly would tighten the result to 1,666,670 bytes
per second. Recognizing that shared-client relationship is left as a checker
precision improvement.

Coil calls are represented by contracts on the small composable functions that
invoke Coil. They are ready for future UI-specific entry points, but are not
reachable from the current film-details ViewModel entry point.
