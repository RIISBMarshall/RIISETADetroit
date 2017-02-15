package riis.etadetroit.model;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import junit.framework.TestCase;

import org.junit.Before;

/**
 * Created by bmarshall on 2/14/17.
 */
public class CompanyDataTest extends TestCase {

    private CompanyData companyData;

    Context mContext;

    @Before
    public void setUp() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"company"});
        matrixCursor.addRow(new Object[]{"SmartBus"});
        matrixCursor.addRow(new Object[]{"DDOT"});
        matrixCursor.addRow(new Object[]{"RefleX"});
        Cursor companyNames = matrixCursor;
        companyData = new CompanyData(companyNames);
        mContext = mock(Context.class);

        when(mContext.getResources().getIdentifier("smartbus", "drawable", "packname")).thenReturn(0);
        when(mContext.getResources().getIdentifier("ddot", "drawable", "packname")).thenReturn(1);
        when(mContext.getResources().getIdentifier("reflex", "drawable", "packname")).thenReturn(2);
        when(mContext.getPackageName()).thenReturn("packname");
    }


    public void testGetCompanyName() throws Exception {
        assertEquals(companyData.getCompanyName(0), "SmartBus");
        assertEquals(companyData.getCompanyName(1), "DDOT");
        assertEquals(companyData.getCompanyName(2), "RefleX");
    }

    public void testGetCompanyImageResourceId() throws Exception {
        assertEquals(1, companyData.getCompanyImageResourceId(mContext, 1));
    }

}