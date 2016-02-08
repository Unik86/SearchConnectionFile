package com.java.actions;

import com.intellij.find.FindModel;
import com.intellij.find.findInProject.FindInProjectManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

/**
 * Created by Unik on 07.02.2016.
 */
public class SearchConnectionFileAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        Project project = e.getData(PlatformDataKeys.PROJECT);
        java.lang.String fileName = file.getName();
        fileName = fileName.replace(".blade.php", "");

        FindModel findModel = new FindModel();
        findModel.setWholeWordsOnly(true);
        findModel.setFromCursor(false);
        findModel.setGlobal(true);
        findModel.setMultipleFiles(true);
        findModel.setProjectScope(true);

        findModel.setStringToFind(fileName);

        FindInProjectManager find = new FindInProjectManager(project);
        find.startFindInProject(findModel);
    }
}
