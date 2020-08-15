package test;

import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirList {

    public static void main(String[] args) {

        String path = "C:\\Users\\Administrator.SC-201907211150\\Desktop\\layui";
        File file = new File(path);
        if (file.exists() && file.isDirectory()){
            int depth = 1;
            TreeNode rootNode = new TreeNode(file.getName(), file.getAbsolutePath(), true);
            List<TreeNode> children = new ArrayList<TreeNode>();
            rootNode.setChildren(children);
            builTree(rootNode, file, children, depth);
            depth--;
            Gson gson = new Gson();
            System.out.println(gson.toJson(rootNode));
            System.out.println(depth);
        }

    }

    private static void builTree(TreeNode rootNode, File file, List<TreeNode> children, int depth) {
        depth++;
        if (file.isFile()){
            return;
        } else {
            File[] files = file.listFiles();
            for (File file1 : files) {
                boolean spread = depth == 2 ? true : false;
                TreeNode node = new TreeNode(file1.getName(), file1.getAbsolutePath(), spread);
                children.add(node);

                List<TreeNode> children2 = new ArrayList<TreeNode>();
                node.setChildren(children2);
                builTree(node, file1, children2, depth);
                depth--;
            }
        }
    }


}
