package com.pmb.structure.composite;

public class Client {
	public static void main(String[] args) {
		AbstractFile a2, a3, a5, a6;
		Folder a1 = new Folder("pic folder");
		a2 = new ImgFile("zzj.jpg");
		a3 = new VideoFile("zzz.mp4");
		a1.add(a2);
		a1.add(a3);
		Folder a4 = new Folder("video folder");
		a5 = new ImgFile("hello.jpg");
		a6 = new ImgFile("java.jpg");
		a4.add(a5);
		a4.add(a6);
		Folder f = new Folder("root");
		f.add(a1);
		f.add(a4);
		f.killVirus();
	} 
}
