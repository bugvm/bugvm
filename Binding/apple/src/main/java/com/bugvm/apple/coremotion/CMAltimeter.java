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
package com.bugvm.apple.coremotion;

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
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("CoreMotion") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CMAltimeter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CMAltimeterPtr extends Ptr<CMAltimeter, CMAltimeterPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(CMAltimeter.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CMAltimeter() {}
    protected CMAltimeter(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "startRelativeAltitudeUpdatesToQueue:withHandler:")
    public native void startRelativeAltitudeUpdates(NSOperationQueue queue, @Block VoidBlock2<CMAltitudeData, NSError> handler);
    @Method(selector = "stopRelativeAltitudeUpdates")
    public native void stopRelativeAltitudeUpdates();
    @Method(selector = "isRelativeAltitudeAvailable")
    public static native boolean isRelativeAltitudeAvailable();
    /*</methods>*/
}
