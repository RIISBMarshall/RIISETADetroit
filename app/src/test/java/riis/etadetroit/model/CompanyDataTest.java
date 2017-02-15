package riis.etadetroit.model;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.widget.CursorAdapter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import junit.framework.TestCase;

import org.junit.Before;

/**
 * Created by bmarshall on 2/14/17.
 */
public class CompanyDataTest extends TestCase {

    public CompanyData companyData;
    public int position;

    @Before
    public void setUp() {

    }

    public void testGetCompanyName() throws Exception {
        Cursor companyNames = mock(Cursor.class);
        when(companyNames.moveToPosition(position)).thenReturn(true);
        when(companyNames.getString(0)).thenReturn("SmartBus");
        companyData = new CompanyData(companyNames);
        position = 0;
        assertEquals("SmartBus", companyData.getCompanyName(position));
    }
}