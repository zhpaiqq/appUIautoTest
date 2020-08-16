package com.dahua.tc.gaea.util;

import com.zf.zson.ZSON;
import com.zf.zson.result.ZsonResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Adb Shell工具类.
 *
 * @author kay
 * @since 2019-12-26
 */
public class AdbShellUtils {

    public static final String COMMAND_CMD = "cmd /c";

    private AdbShellUtils() {
        throw new AssertionError();
    }

    public static CommandResult execCommand(List<String> commands, boolean isNeedResultMsg) {
        return execCommand(commands == null ? null : commands.toArray(new String[]{}), isNeedResultMsg);
    }

    public static CommandResult execCommand(String[] commands, boolean isNeedResultMsg) {
        int result = 1;
        if (commands == null || commands.length == 0) {
            return new CommandResult(result, null, null);
        }

        Process process = null;
        BufferedReader successResult = null;
        BufferedReader errorResult = null;
        StringBuilder successMsg = null;
        StringBuilder errorMsg = null;

        try {
            ProcessBuilder pb = new ProcessBuilder(commands);
            pb.redirectErrorStream(true);
            process = pb.start();
            for (String command : commands) {
                if (command == null) {
                    continue;
                }
            }

            if (isNeedResultMsg) {
                successMsg = new StringBuilder();
                errorMsg = new StringBuilder();
                successResult = new BufferedReader(new InputStreamReader(process.getInputStream()));
                errorResult = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                String line = null;
                while ((line = successResult.readLine()) != null) {
                    successMsg.append(line + "\n");
                }
                while ((line = errorResult.readLine()) != null) {
                    errorMsg.append(line + "\n");
                }
            }
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (successResult != null) {
                    successResult.close();
                }
                if (errorResult != null) {
                    errorResult.close();
                }
                if (process != null) {
                    process.destroy();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new CommandResult(result, successMsg == null ? null : successMsg.toString(),
                errorMsg == null ? null : errorMsg.toString());
    }

    public static class CommandResult {
        /**
         * result of command
         */
        public int result;
        /**
         * success message of command result
         */
        public String successMsg;
        /**
         * error message of command result
         */
        public String errorMsg;

        public CommandResult(int result) {
            this.result = result;
        }

        public CommandResult(int result, String successMsg, String errorMsg) {
            this.result = result;
            this.successMsg = successMsg;
            this.errorMsg = errorMsg;
        }
    }

    public static CommandResult processBuilderCommand(List<String> commands, boolean isNeedResultMsg) {
        return execCommand(commands, isNeedResultMsg);
    }

    public static void main(String[] args) {
        List<String> commands = new ArrayList<>();
        commands.add("cmd.exe");
        commands.add("/c");
        commands.add("ffprobe.exe -v quiet -print_format json -show_format -show_streams test.mp4");
        CommandResult result = processBuilderCommand(commands, true);
        System.out.println("------------------------------");
        System.out.println(result.successMsg);
        ZsonResult zr = ZSON.parseJson(result.successMsg);
        System.out.println(zr.getValue("//*[0]/codec_long_name"));
        System.out.println("------------------------------");
    }
}

