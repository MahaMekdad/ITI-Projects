package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class FileBrowserController implements Initializable {
    @FXML
    private TreeView treeViewId;
    @FXML
    private ListView listViewId;
    @FXML
    private ComboBox directoriesListId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File[] roots = File.listRoots();
        for(int i = 0; i < roots.length; i++) {
            if(!roots[i].getPath().equals("C:\\")){
                directoriesListId.getItems().add(roots[i]);
            }
        }

        treeViewId.setCellFactory(new Callback<TreeView, TreeCell>() {
            @Override
            public TreeCell call(TreeView treeView) {
                return new TreeCell<File>(){
                    @Override
                    protected void updateItem(File f, boolean empty){
                        super.updateItem(f, empty);
                        ImageView folderIcon = new ImageView(new Image(String.valueOf(getClass().getResource("/org/example/icons/folderIcon.jpg"))));
                        ImageView fileIcon = new ImageView(new Image(String.valueOf(getClass().getResource("/org/example/icons/file-icon.png"))));
                        if(f != null){
                            //if(f.getName().equals("RootItem")){
                            if(f == treeViewId.getRoot().getValue()){
                                setText("");
                                setGraphic(folderIcon);
                            } else{
                                setText(f.getName());
                                if(f.isDirectory())
                                    setGraphic(folderIcon);
                                else
                                    setGraphic(fileIcon);
                            }
                        } else{
                            setText("");
                            setGraphic(null);
                        }
                    }
                };
            }
        });
    }
    public void onChosenDir(ActionEvent actionEvent) {
        System.out.println(directoriesListId.getValue()+"CHOSEN");
        File rootFile = new File("RootItem");
        TreeItem<File> treeRoot = new TreeItem(rootFile, new ImageView(new Image(String.valueOf(getClass().getResource("/org/example/icons/folderIcon.jpg")))));
        File f = new File(directoriesListId.getValue().toString());
        File files [] = f.listFiles();
        for (File file : files) {
            Node folderIcon = new ImageView(new Image(String.valueOf(getClass().getResource("/org/example/icons/folderIcon.jpg"))));
            Node fileIcon = new ImageView(new Image(String.valueOf(getClass().getResource("/org/example/icons/file-Icon.png"))));
            try{
                TreeItem<File> fileTreeItem;
                if(file.isDirectory()){
                    fileTreeItem= new TreeItem<>(file, folderIcon);
                    File returnedFiles [] = getFiles(file);
                    addFiles(returnedFiles, fileTreeItem);
                    treeRoot.getChildren().add(fileTreeItem);
                }
                else{
                    fileTreeItem= new TreeItem<>(file, fileIcon);
                    treeRoot.getChildren().add(fileTreeItem);
                }
            } catch (Exception e){
                continue;
            }
        }
        treeViewId.setRoot(treeRoot);
    }

    public File[] getFiles(File file){
        return file.listFiles();
    }
    public void addFiles(File [] files, TreeItem parentTree){
        for (File file: files) {
            try {
                Node fileIcon = new ImageView(new Image(String.valueOf(getClass()
                        .getResource("/org/example/icons/file-Icon.png"))));
                Node folderIcon = new ImageView(new Image(String.valueOf(getClass()
                        .getResource("/org/example/icons/folderIcon.jpg"))));
                TreeItem<File> fileItem;
                if(file.isDirectory()){
                    fileItem = new TreeItem<>(file,folderIcon);
                    File returnedFiles [] = getFiles(file);
                    addFiles(returnedFiles, fileItem);
                    parentTree.getChildren().add(fileItem);
                }
                else{
                    fileItem = new TreeItem<>(file,fileIcon);
                    parentTree.getChildren().add(fileItem);
                }
            } catch (Exception e){
                continue;
            }
        }
    }

    public void clickHandle(TreeItem<File> node){
        ObservableList<String> fileNames = FXCollections.<String>observableArrayList();;
        ObservableList<TreeItem<File>> treeItems = null;
        //if(!(node.getValue().toString().contains("."))){
        if(node.getValue().isDirectory()){
            treeItems = node.getChildren();
            for (TreeItem<File> treeItemNode : treeItems) {
                try {
                    fileNames.add(treeItemNode.getValue().getName().toString());
                } catch (Exception e){
                    continue;
                }
            }
        }
        else{
            fileNames.add(node.getValue().getName().toString());
        }
        listViewId.setItems(fileNames);
    }

    public void selectedItem(MouseEvent mouseEvent) {
        TreeItem<File> selectedItem = (TreeItem<File>) treeViewId.getSelectionModel().getSelectedItem();
        if(selectedItem != null && !(selectedItem.getValue().equals(treeViewId.getRoot().getValue()))){
            System.out.println(selectedItem.getValue()+" value <-");
            clickHandle(selectedItem);
        }
        System.out.println("mouse clicked?");
    }
}
