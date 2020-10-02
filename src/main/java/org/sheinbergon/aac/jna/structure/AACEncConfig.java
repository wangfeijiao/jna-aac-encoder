package org.sheinbergon.aac.jna.structure;

import com.sun.jna.Structure;
import org.sheinbergon.aac.jna.util.JNASupport;

import java.util.List;

/**
 * Maps to AACENC_CONFIG struct.
 *
 * @see <a href="https://github.com/mstorsjo/fdk-aac/blob/v0.1.6/libAACenc/src/aacenc.h">fdk-aac/libAACenc/src/aacenc.h</a>
 */
public class AACEncConfig extends Structure {

    private static final List<String> FIELD_ORDER = JNASupport.structureFieldOrder(AACEncConfig.class);

    public int sampleRate;
    public int bitRate;
    public int ancDataBitRate;
    public int nSubFrames;
    public int audioObjectType;
    public int averageBits;
    public int bitrateMode;
    public int nChannels;
    public int channelOrder;
    public int bandWidth;
    public int channelMode;
    public int framelength;
    public int syntaxFlags;
    public byte epConfig;
    public int anc_Rate;
    public int maxAncBytesPerAU;
    public int minBitsPerFrame;
    public int maxBitsPerFrame;
    public int bitreservoir;
    public int audioMuxVersion;
    public int sbrRatio;
    public byte useTns;
    public byte usePns;
    public byte useIS;
    public byte useRequant;

    @Override
    protected final List<String> getFieldOrder() {
        return FIELD_ORDER;
    }
}