
public class XeMay implements Bai2 {
	int thang;
	int tocDo;
	int kg;

	@Override
	public void doThang( int a) {
		this.thang=a;
		System.out.println("120");
		
	}

	@Override
	public void tocDo(int a) {
		this.tocDo=a;
		// TODO Auto-generated method stub
		System.out.println("10000000000000cc");
		
	}

	@Override
	public void canNang(int a) {
		this.kg=a;
		// TODO Auto-generated method stub
		System.out.println("200kg");
		
	}
	public void print() {
		System.out.println("dothang:"+thang);
		System.out.println("tocDo:"+tocDo);
		System.out.println("can nang:"+kg);
	}
	
}

