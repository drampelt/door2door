package lt.danielrampe.door2door.content;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import com.tjeannin.provigen.ProviGenOpenHelper;
import com.tjeannin.provigen.ProviGenProvider;

/**
 * Created by Daniel on 2015-06-25.
 */
public class Door2DoorProvider extends ProviGenProvider {

    public static final String CONTENT_PATH = "content://lt.danielrampe.door2door.provider";
    public static final Uri CONTENT_URI = Uri.parse(CONTENT_PATH);

    @Override
    public SQLiteOpenHelper openHelper(Context context) {
        return new ProviGenOpenHelper(getContext(), "door2door", null, 1, contractClasses());
    }

    @Override
    public Class[] contractClasses() {
        return new Class[]{};
    }
}
