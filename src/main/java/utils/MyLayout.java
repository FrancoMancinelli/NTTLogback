package utils;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.LayoutBase;

public class MyLayout extends LayoutBase<ILoggingEvent> {

	private String prefix;

	private String provincia;

	private String currD;

	private boolean printThreadName = Boolean.TRUE;

	@Override
	public String doLayout(ILoggingEvent event) {

		final StringBuffer sb = new StringBuffer(200);

		sb.append(currD);
		sb.append(" | ");
		sb.append(prefix);
		sb.append(" | ");
		sb.append(provincia);
		sb.append(" ");

		if (printThreadName) {
			sb.append("[");
			sb.append(event.getThreadName());
			sb.append("] ");
		}

		sb.append(event.getLoggerName());
		sb.append(" ");
		sb.append(event.getLevel());
		sb.append(": ");
		sb.append(event.getFormattedMessage());
		sb.append("\n");

		return sb.toString();
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public boolean isPrintThreadName() {
		return printThreadName;
	}

	public void setPrintThreadName(boolean b) {
		printThreadName = b;
	}

	public String getCurrD() {
		return currD;
	}

	public void setCurrD(String cd) {
		currD = cd;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String p) {
		provincia = p;
	}
}
