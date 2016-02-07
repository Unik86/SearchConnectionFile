package com.java.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;

/**
 * Created by Unik on 07.02.2016.
 */
public class SearchConnectionFileAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        String fileName = file.getName();

        Messages.showMessageDialog("File - " + fileName, "Project View Action", Messages.getInformationIcon());
    }
}
