package studio6;

import jssc.*;


public class SerialComm {


	SerialPort port;

	private boolean debug;  // Indicator of "debugging mode"
	
	// This function can be called to enable or disable "debugging mode"
	void setDebug(boolean mode) {
		debug = mode;
	}	
	

	// Constructor for the SerialComm class
	public SerialComm(String name) throws SerialPortException {
		port = new SerialPort(name);		
		port.openPort();
		port.setParams(SerialPort.BAUDRATE_9600,
			SerialPort.DATABITS_8,
			SerialPort.STOPBITS_1,
			SerialPort.PARITY_NONE);
		
		debug = false; // Default is to NOT be in debug mode
	}
		
	// TODO: Add writeByte() method from Studio 5
	
	// TODO: Add available() method
	public boolean available() throws SerialPortException {
		if (port.getInputBufferBytesCount() > 0) {
			return true;
		}
		return false;
	}
	
	// TODO: Add readByte() method	
	
	public byte readByte() throws SerialPortException {
		return port.readBytes()[0];
	}
	
	// TODO: Add a main() method
	public static void main(String[] args) throws SerialPortException{ 
		
		SerialComm com = new SerialComm("/dev/cu.usbserial-DN02AZYQ");
		while (true) {
			if(com.available()) {
				byte x = com.readByte();
				System.out.print((char) x);
			}
			}
		}
	
	}



