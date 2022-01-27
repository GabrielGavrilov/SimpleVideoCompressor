package Compressor;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;

import java.io.IOException;

public class ffmpeg {

    private static String _videoInputLocation;
    private static String _compressedOutputLocation;

    private static int _videoWidth;
    private static int _videoHeight;
    private static int _videoFrameRate;
    private static String _videoFormat;

    private static int _audioSampleRate;
    private static int _audioBitRate;

    public static void compressVideo() throws IOException {

        FFmpeg mpeg = new FFmpeg("./ffmpeg/bin/ffmpeg.exe");
        FFprobe probe = new FFprobe("./ffmpeg/bin/ffprobe.exe");

        try {

            FFmpegBuilder builder = new FFmpegBuilder()

                    .setInput(_videoInputLocation)
                    .overrideOutputFiles(true)

                    .addOutput(_compressedOutputLocation)
                    .setFormat(_videoFormat)
                    .disableSubtitle()

                    .setAudioChannels(1)
                    .setAudioCodec("aac")
                    .setAudioSampleRate(_audioSampleRate)
                    .setAudioBitRate(_audioBitRate)

                    .setVideoCodec("libx264")
                    .setVideoFrameRate(_videoFrameRate, 1)
                    .setVideoResolution(_videoWidth, _videoHeight)

                    .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL)
                    .done();

            FFmpegExecutor executor = new FFmpegExecutor(mpeg, probe);
            executor.createJob(builder).run();

        } catch(Exception e) {

            System.out.println(e);

        }

    }

    public static void setVideoLocation(String location) {
        _videoInputLocation = location;
        System.out.println("Set video input location.");
    }

    public static void setCompressedOutputLocation(String location) {
        _compressedOutputLocation = location;
        System.out.println("Set compressed video output location.");
    }

    public static void setVideoWidth(int width) {
        _videoWidth = width;
        System.out.println("Set video width.");
    }

    public static void setVideoHeight(int height) {
        _videoHeight = height;
        System.out.println("Set video height.");
    }

    public static void setVideoFrameRate(int frameRate) {
        _videoFrameRate = frameRate;
        System.out.println("Set video frame rate.");
    }

    public static void setVideoFormat(String format) {
        _videoFormat = format;
        System.out.println("Set video format.");
    }

    public static void setAudioSampleRate(int sampleRate) {
        _audioSampleRate = sampleRate;
        System.out.println("Set audio sample rate.");
    }

    public static void setAudioBitRate(int bitRate) {
        _audioBitRate = bitRate;
        System.out.println("Set bit rate.");
    }

}
