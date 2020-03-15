package project02;

import java.io.File;

public class AccessData {
		private String path;
		private int mode;

		public AccessData(String p, int m) {
			path = p;
			mode = m;
		}

		public String getPath() {
			return path;
		}

		public int getMode() {
			return mode;
		}

		public void setPath(String p) {
			path = p;
		}

		public void setMode(int m) {
			mode = m;
		}
	}