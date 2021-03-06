/*
 * Copyright (C) 2013-2015 RoboVM AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bugvm.apple.scenekit;

/*<imports>*/
import java.io.*;
import java.nio.*;
import java.util.*;
import com.bugvm.objc.*;
import com.bugvm.objc.annotation.*;
import com.bugvm.objc.block.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.glkit.*;
import com.bugvm.apple.spritekit.*;
import com.bugvm.apple.opengles.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("SceneKit") @StronglyLinked/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SCNError/*</name>*/ 
    extends /*<extends>*/NSError/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    protected SCNError(SkipInit skipInit) {
        super(skipInit);
    }
    
    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { Bro.bind(SCNError.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    private NSErrorUserInfo userInfo;
    
    /* Convenience methods */
    private NSErrorUserInfo getCachedUserInfo() {
        if (userInfo == null) {
            userInfo = getUserInfo();
        }
        return userInfo;
    }
    
    @Override
    public NSErrorCode getErrorCode() {
        NSErrorCode code = null;
        try {
            code = SCNConsistencyErrorCode.valueOf(getCode());
        } catch (IllegalArgumentException e) {
            try {
                code = SCNErrorCode.valueOf(getCode());
            } catch (IllegalArgumentException e2) {
                // ignored
            }
        }
        return code;
    }
//    
//    @SuppressWarnings("unchecked")
//    public NSErrorUserInfo getConsistencyError() {
//        if (getCachedUserInfo().has(SCNErrorUserInfoKey.DetailedErrors)) {
//            NSDictionary<NSString, NSObject> val = (NSDictionary<NSString, NSObject>) getCachedUserInfo().get(SCNErrorUserInfoKey.DetailedErrors);
//            return new NSErrorUserInfo(val);
//        }
//        return null;
//    }
    /*<methods>*/
    @GlobalValue(symbol="SCNErrorDomain", optional=true)
    public static native String getClassDomain();
    /*</methods>*/
}
