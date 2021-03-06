/*
 * Copyright (C) 2017 BugVM
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
package com.bugvm.sound;

import javax.sound.sampled.*;

public class YSourceDataLine extends YDataLine implements SourceDataLine {
    public YSourceDataLine() {
        if(Boolean.getBoolean("YDEBUG")) {
            System.out.println("returning from YSourceDataLine()");
        }
    }
    
    public YSourceDataLine(Line.Info info) {
        super(info);
        if(Boolean.getBoolean("YDEBUG")) {
            System.out.println("returning from YSourceDataLine(Line.Info info)");
        }
    }
    
    @Override
    public void open(AudioFormat audioFormat, int BufferSize) throws LineUnavailableException {
        //let YDataLine know the audioFormat
        super.open(audioFormat,BufferSize);
        //
        int Encoding = 0;// convert this to int, audioFormat.getEncoding();
        int FrameRate = (int)audioFormat.getFrameRate();
        int BitsPerSample = audioFormat.getSampleSizeInBits();
        int Channels = audioFormat.getChannels();
        int FrameSize= audioFormat.getFrameSize();
        int SampleRate = (int)audioFormat.getSampleRate();
        boolean isBigEndian = audioFormat.isBigEndian();
        int device = YNative.GetDefaultOutputDevice();
        YNative.OutputLineOpen(device,Encoding,FrameRate,BitsPerSample,Channels,FrameSize,SampleRate,isBigEndian,BufferSize);
    }
    //
    @Override
    public void open(AudioFormat audioFormat) throws LineUnavailableException {
        open(audioFormat, 1024);
    }
    
    @Override
    public int write(byte[] buffer, int offset, int length) {
        return YNative.write(buffer, offset, length);
    }
}