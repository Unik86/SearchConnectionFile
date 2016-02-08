package com.java.actions;

import com.intellij.find.FindModel;
import com.intellij.find.findInProject.FindInProjectManager;
import com.intellij.find.impl.FindInProjectUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.usageView.UsageInfo;
import com.intellij.usages.FindUsagesProcessPresentation;
import com.intellij.util.CommonProcessors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Unik on 07.02.2016.
 */
public class SearchConnectionFileAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        Project project = e.getData(PlatformDataKeys.PROJECT);
        java.lang.String fileName = file.getName();

//        Messages.showMessageDialog("File - " + fileName, "Project View Action", null);
//        JBPopupFactory mes = new PopupFactoryImpl();
//        ComponentPopupBuilder componentPopupBuilder = mes.createComponentPopupBuilder();
//
//        DefaultWordsScanner sc = new DefaultWordsScanner();
//        sc.processWords(fileName, Processor.TRUE);
//
//        PsiSearchHelper ss = new PsiSearchHelperImpl();

//        CompositeShortNamesCache sd = new CompositeShortNamesCache(project);
//        PsiFile[] files = sd.getFilesByName(fileName);
//        String s = files[0].getName();
//        FileType ft = files[0].getFileType();
//        files[0].getFileType();

        FindModel findModel = new FindModel();
        findModel.setWholeWordsOnly(true);
        findModel.setFromCursor(false);
        findModel.setGlobal(true);
        findModel.setMultipleFiles(true);
        findModel.setProjectScope(true);

        findModel.setStringToFind("java.util");

//        List<UsageInfo> usages = findUsages(findModel, project);
//        usages.get(0);

        FindInProjectManager find = new FindInProjectManager(project);
        find.startFindInProject(findModel);
    }

    private List<UsageInfo> findUsages(FindModel findModel, Project project) {
        List<UsageInfo> result = new ArrayList<>();
        final CommonProcessors.CollectProcessor<UsageInfo> collector = new CommonProcessors.CollectProcessor<>(result);
        FindInProjectUtil.findUsages(findModel, project, collector, new FindUsagesProcessPresentation(FindInProjectUtil.setupViewPresentation(true, findModel)));
        return result;
    }
}
