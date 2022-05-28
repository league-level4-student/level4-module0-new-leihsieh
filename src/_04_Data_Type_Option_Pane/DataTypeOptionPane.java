package _04_Data_Type_Option_Pane;

import javax.swing.JOptionPane;

public class DataTypeOptionPane {
    enum DataType {
    	BOOLEAN(1), CHAR(16), BYTE(8), SHORT(16), INT(32), LONG(64), FLOAT(32), DOUBLE(64);
    	private int bits;
    	private DataType(int bits) {
    		this.bits = bits;
    	}
    	public int getBits() {
    		return this.bits;
    	}
    }
	public static void main(String[] args) {
        DataType[] dt = DataType.values();
        int res = JOptionPane.showOptionDialog(null, "Select the data type you would like to learn more about", "sick title", 0, 0, null, dt, dt);
        switch (res) {
        
        case 0:
        	JOptionPane.showMessageDialog(null, "Boolean variables can hold two values: true or false.\nBoolean variables hold " + dt[res].getBits() + " bit.");
        	break;
	    case 1:
	    	JOptionPane.showMessageDialog(null, "Char variables hold numbers from 0 up to 65,535 inclusive.\nChar variables hold " + dt[res].getBits() + " bits.");
	    	break;
	    case 2:
	    	JOptionPane.showMessageDialog(null, "Byte variables hold numbers from -128 to 127 inclusive.\nByte variables hold " + dt[res].getBits() + " bits.");
	    	break;
	    case 3:
	    	JOptionPane.showMessageDialog(null, "Short variables hold numbers from -32,768 to 32,767 inclusive.\nShort variables hold " + dt[res].getBits() + " bits.");
	    	break;
	    case 4:
	    	JOptionPane.showMessageDialog(null, "Int variables hold numbers from -2^31 to 2^31 - 1 inclusive.\nInt variables hold " + dt[res].getBits() + " bits.");
	    	break;
	    case 5:
	    	JOptionPane.showMessageDialog(null, "Long variables hold numbers from -2^63 to 2^63 - 1 inclusive.\nLong variables hold " + dt[res].getBits() + " bits.");
	    	break;
	    case 6:
	    	JOptionPane.showMessageDialog(null, "Float variables hold numbers that are not an integer.\nFloat variables hold " + dt[res].getBits() + " bits.");
	    	break;
	    case 7:
	    	JOptionPane.showMessageDialog(null, "Double variables hold numbers that are not an integer, with a greater range than float variables.\nByte variables can hold " + dt[res].getBits() + " bits.");
	    	break;
	    }
	}
}
