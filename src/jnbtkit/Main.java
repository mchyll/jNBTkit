package jnbtkit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.jnbt.NBTInputStream;
import org.jnbt.Tag;

/**
 *
 * @author magnus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RegionFile rf = new RegionFile(new File("/home/magnus/.minecraft/saves/world2/region/r.0.0.mcr"));

        try {
            new Main().readNBT(rf.getChunkDataInputStream(0, 0));
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
    }

    public void readNBT(InputStream file) throws IOException {
        NBTInputStream stream = new NBTInputStream(file, false);
        Tag tag;

        while(true){
            tag = stream.readTag();
            if(tag == null) break;

            System.out.print(tag.getValue());
        }
    }

}
