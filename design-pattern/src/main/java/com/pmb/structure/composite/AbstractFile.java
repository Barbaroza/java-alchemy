package com.pmb.structure.composite;

import java.util.ArrayList;
import java.util.List;

public interface AbstractFile {
	void killVirus();
}

class ImgFile implements AbstractFile {

	private String name;

	public ImgFile(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println("-- 图片正在杀毒 -- " + name);
	}
}

class VideoFile implements AbstractFile {

	private String name;

	public VideoFile(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println("-- 视频正在杀毒 -- " + name);
	}
}

class Folder implements AbstractFile {

	private String name;

	// 定义容器，用来存放本容器构建下的子节点
	private List<AbstractFile> list = new ArrayList<AbstractFile>();

	public Folder(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println("---文件夹：" + name + ",进行查杀");
		// 对子节点的操作是最重要的
		for (AbstractFile file : list) {
			file.killVirus();
		}
	}

	public void add(AbstractFile file) {
		list.add(file);
	}

	public void remove(AbstractFile file) {
		list.add(file);
	}

	public AbstractFile getChild(int index) {
		return list.get(index);
	}
}
