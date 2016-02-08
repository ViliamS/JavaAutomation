package com.r2development.leveris.bdd.stats;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CucumberListSteps {

    private static Log log = LogFactory.getLog(CucumberListSteps.class);

    public static void main(String[] args) throws IOException {

//        string extractFuncRegex = @"\b[^()]+\((.*)\)$";
//        string extractArgsRegex = @"([^,]+\(.+?\))|([^,]+)";

        CucumberListSteps cucumberListSteps = new CucumberListSteps();
        Map<String, Set<String>> stats = cucumberListSteps.statsModule("/Users/anthonymottot/Automation/Git/qa_automation/Aut-Abakus/Apollo/src/main/java/com/r2development/abakus/bdd/apollo/stepdef");

        int totalStepDef = 0;
        for (Map.Entry<String, Set<String>> detail : stats.entrySet()) {
            totalStepDef += detail.getValue().size();
            log.info(detail.getKey() + " containing " + detail.getValue().size() + " step definitions");
        }
        log.info("totalStepDef File: " + stats.size() + ", totalStepDef: " + totalStepDef);
    }

    public Map<String, Set<String>> statsModule(@SuppressWarnings("SameParameterValue") String pathStepDefModule) throws IOException {
        File stepDefDirectory = FileUtils.getFile(pathStepDefModule);

        Map<String, Set<String>> stats = new LinkedHashMap<>();

        if ( stepDefDirectory.listFiles() != null) {
            //noinspection ConstantConditions
            for (File currentFile : stepDefDirectory.listFiles()) {

                log.info(currentFile.getName());
                List<String> lines = FileUtils.readLines(currentFile);

                Set<String> stepDef = new LinkedHashSet<>();
                for (String currentLine : lines) {
                    Pattern p = Pattern.compile("^.*(@When|@And|@Then).*$");
                    Matcher m = p.matcher(currentLine);

                    String potentialStepDefLine = null;
                    while (m.find()) {
                        potentialStepDefLine = m.group(0);
                    }
                    if (potentialStepDefLine != null) {
                        log.info("Potential Line: " + potentialStepDefLine);
                        stepDef.add(potentialStepDefLine);
                    }
                }

                stats.put(currentFile.getName(), stepDef);
            }
        }

        int totalStepDef = 0;
        for (Map.Entry<String, Set<String>> detail : stats.entrySet()) {
            totalStepDef += detail.getValue().size();
            log.info(detail.getKey() + " containing " + detail.getValue().size() + " step definitions");
        }

        log.info("totalStepDef File: " + stats.size() + ", totalStepDef: " + totalStepDef);
        return stats;
    }
}
