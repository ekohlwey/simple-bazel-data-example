# Minimal Bazel Data Example

This repo shows how to create a bazel artifact with a `data=...` attribute and how to load the data file.

This is based on the instructions in [`Runfiles.java`](https://github.com/bazelbuild/bazel/blob/38918be4f665e4eca69c9f3f5d469be6d63a486b/src/main/java/com/google/devtools/build/lib/analysis/Runfiles.java#L2) from the Bazel project.

To run, execute the following in a shell: `bazel run //:binary_with_data`.
