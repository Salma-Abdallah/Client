// package gov.iti.jets.controllers;

// import javafx.scene.control.ComboBox;
// import javafx.scene.control.ListView;
// import javafx.scene.control.PopupControl;

// public class UpwardComboBox<T> extends ComboBox<T> {

//     @Override
//     public void show() {
//         if (!isShowing()) {
//             ListView listView = getli;
//             double listViewHeight = listView.getFixedCellSize() * Math.min(getItems().size(), getVisibleRowCount()) + 2;
//             PopupControl popup = (PopupControl) getSkin().getPopup();
//             popup.setAnchorY(popup.getAnchorY() - listViewHeight);
//             super.show();
//         }
//     }
// }
