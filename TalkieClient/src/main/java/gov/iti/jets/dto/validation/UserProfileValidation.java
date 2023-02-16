package gov.iti.jets.dto.validation;

import gov.iti.jets.dto.requests.UserProfileRequest;
import gov.iti.jets.dto.responses.UserProfileResponse;
// import gov.iti.jets.mappers.UserMapper;

public class UserProfileValidation {
    private UserProfileRequest request;
    private UserProfileResponse userProfileResponse;
    // private UserMapper userMapper = new UserMapper();


    // public UserProfileValidation() {
    // }

    // public UserProfileValidation(UserProfileRequest request) {
    //     this.request = request;
    // }

    // public boolean validate() {
    //     boolean isValid = true;

    //     if(userMapper.getUserByPhoneNumber(request.getNewPhoneNumber()).isPresent() ){
    //         if(userMapper.getUserByPhoneNumber(request.getNewPhoneNumber()).get() == userMapper.getUserByPhoneNumber(request.getOldPhoneNumber()).get()){
    //             userProfileResponse.setMessage("your request is done successfully");
    //             isValid = true;
    //         }else {
    //             userProfileResponse.setMessage("Phone number already exists");
    //             isValid = false;
    //         }
    //     }
    //     if(userMapper.getUserByEmail(request.getNewEmail()).isPresent()){
    //         if(userMapper.getUserByEmail(request.getNewEmail()).get() == userMapper.getUserByEmail(request.getOldEmail()).get()) {
    //             userProfileResponse.setMessage("your request is done successfully");
    //             isValid = true;
    //         }
    //         else {
    //             userProfileResponse.setMessage("Email already exists");
    //             isValid = false;
    //         }
    //     }


    //     return isValid;
    // }


}
