package gov.iti.jets.controllers;

public class FXMLControllerFactory {

    public static FXMLController getController(String controller){
        if(controller.equals("user-profile")){
            // return new UserProfileController();
        }else if(controller.equals("block-list")){
            return new BlockListController();
        }else if(controller.equals("welcome")){
            return new WelcomeController();
        }else if(controller.equals("login-page-username")){
            return new LoginPageUsernameFxmlController();
        }else if(controller.equals("login-page-password")){
            return new LoginPagePasswordFxmlController();
        }else if(controller.equals("signup-page")){
            return new SignupPageFxmlController();
        }else if(controller.equals("main-alignment")){
            return new MainAlignmentController();
        }else if(controller.equals("message")){
            return new MessageControllerFXML();
        }else if(controller.equals("side-bar")){
            return new sideBarController();
        }else if(controller.equals("default-content")){
            return new DefaultContentController();
        }else if(controller.equals("chatting-panel")){
            return new ChattingPanelController();
        }else if(controller.equals("friend-request")){
            return new FriendRequestsController();
        }
        // Add controllers here whenever you add a new layout to be loaded
        return null;
    }
}
