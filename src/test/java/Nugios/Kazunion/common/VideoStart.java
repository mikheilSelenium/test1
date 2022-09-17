package Nugios.Kazunion.common;

import VideoRecorder.VideoRecorder_utlity;
import org.testng.annotations.Test;


public class VideoStart extends RunChrome {

    @Test
    public static void Video() throws Exception{

        VideoRecorder_utlity.startRecord("TestRecording");
    }
}