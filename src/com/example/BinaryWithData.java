package com.example;

import com.google.devtools.build.runfiles.AutoBazelRepository;
import java.io.BufferedReader;
import java.io.FileReader;
import com.google.devtools.build.runfiles.Runfiles;

@AutoBazelRepository
class BinaryWithData{
    public static void main(String[] args) throws Throwable {
        Runfiles.Preloaded runfiles = Runfiles.preload();
        // Option 1: Load without an environment variable. You can set the module name (as shown here -
        // runfiles_example) in MODULE.bazel or use _main (the default repository name). This requires using the
        // @AutoBazelRepository annotation.
        String option1Path = runfiles.withSourceRepository(AutoBazelRepository_BinaryWithData.NAME)
            // or use "_main/test_text_file.txt" if your repo uses the default name.
            .rlocation("runfiles_example/test_text_file.txt");
        // Option 2: Load with an environment variable. This requires setting the "env" attribute in the build rule.
        // this does not require an annotation but does require your build rule to support "Make Variable" expansion in
        // the env attribute (see https://docs.bazel.build/versions/master/be/make-variables.html#env)
        String option2Path = runfiles.unmapped().rlocation(System.getenv("TEST_TEXT_FILE"));

        // Print the contents of the file using each method.
        printFile(option1Path);
        printFile(option2Path);
    }

    private static void printFile(String path) throws Throwable{
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        System.out.println("test_text_file.txt contains:");
        System.out.println(line);
        reader.close();
    }
}