public class Ex15_2{
	public static void main(String[] args){
		String folder1="c:\\javadev\\";
		String file="readme.md";
		System.out.println(getFullPath(folder1,file));
		String folder2="c:\\hoge";
		System.out.println(getFullPath(folder2,file));

	}
	static String getFullPath(String folder,String file){
		if(!folder.endsWith("\\")){
			folder=folder+"\\";
		}
		return folder+file;
	}
}
