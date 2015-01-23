package vfs;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.junit.Test;

/**
 * Created by saberseddik on 15-01-08.
 */
public class TestVFS {

    @Test
    public void testCreateDirectoriesAndFiles() throws FileSystemException {
        FileSystemManager fsManager = VFS.getManager();
        FileObject folder = fsManager.resolveFile( "ram:/Users/saberseddik/test" );
        return;
    }
}
