
public class FibFun {
	static double p = (1 + Math.sqrt(5))/2;
	static double t = (1 - Math.sqrt(5))/2;
	static Complex phi = new Complex(p,0);
	static Complex tau = new Complex(t,0);	
	
	public static Complex getStartVal(int a) {
		double tta = Math.pow(2, a);
		return new Complex(1/(Math.pow(Math.sqrt(5), tta)),0);
	}
	
	public static Complex binetFormula(Complex n) {
		return new Complex(1/Math.sqrt(5),0).times((phi.pow(n)).minus((tau.pow(n))));
	}
	
	public static Complex multipleFormula(Complex n) {
		return getStartVal(1).times((phi.pow(n).minus(tau.pow(n)))
				.times((phi.pow(n.plus(new Complex(1,0))).minus(tau.pow(n.plus(new Complex(1,0))))))
				);
	}
	
	public static Complex multipleFormula2(Complex n) {
		return getStartVal(2).times((phi.pow(n).minus(tau.pow(n)))
				.times(((phi.pow(n.plus(new Complex(1,0))).minus(tau.pow(n.plus(new Complex(1,0)))))).pow(new Complex(2,0)))
				.times((phi.pow(n.plus(new Complex(2,0))).minus(tau.pow(n.plus(new Complex(2,0))))))
				);
	}
	
	public static Complex multipleFormula3(Complex n) {
		return getStartVal(3).times((phi.pow(n).minus(tau.pow(n))) 
				.times((phi.pow(n.plus(new Complex(1,0))).minus(tau.pow(n.plus(new Complex(1,0))))).pow(new Complex(3,0)))
				.times((phi.pow(n.plus(new Complex(2,0))).minus(tau.pow(n.plus(new Complex(2,0))))).pow(new Complex(3,0)))
				.times(phi.pow(n.plus(new Complex(3,0))).minus(tau.pow(n.plus(new Complex(3,0)))))
				);	
	}
	
	public static Complex multipleFormula4(Complex n) {
		return getStartVal(4).times((phi.pow(n).minus(tau.pow(n))) 
				.times((phi.pow(n.plus(new Complex(1,0))).minus(tau.pow(n.plus(new Complex(1,0))))).pow(new Complex(4,0)))
				.times((phi.pow(n.plus(new Complex(2,0))).minus(tau.pow(n.plus(new Complex(2,0))))).pow(new Complex(6,0)))
				.times((phi.pow(n.plus(new Complex(3,0))).minus(tau.pow(n.plus(new Complex(3,0))))).pow(new Complex(4,0)))
				.times(phi.pow(n.plus(new Complex(4,0))).minus(tau.pow(n.plus(new Complex(4,0)))))
				);	
	}
	
	public static Complex multipleFormula5(Complex n) {
		return getStartVal(5).times((phi.pow(n).minus(tau.pow(n))) 
				.times((phi.pow(n.plus(new Complex(1,0))).minus(tau.pow(n.plus(new Complex(1,0))))).pow(new Complex(5,0)))
				.times((phi.pow(n.plus(new Complex(2,0))).minus(tau.pow(n.plus(new Complex(2,0))))).pow(new Complex(10,0)))
				.times((phi.pow(n.plus(new Complex(3,0))).minus(tau.pow(n.plus(new Complex(3,0))))).pow(new Complex(10,0)))
				.times((phi.pow(n.plus(new Complex(4,0))).minus(tau.pow(n.plus(new Complex(4,0))))).pow(new Complex(5,0)))
				.times(phi.pow(n.plus(new Complex(5,0))).minus(tau.pow(n.plus(new Complex(5,0)))))
				);
	}
	
	public static Complex multipleFormula6(Complex n) {
		return getStartVal(5).times((phi.pow(n).minus(tau.pow(n))) 
				.times((phi.pow(n.plus(new Complex(1,0))).minus(tau.pow(n.plus(new Complex(1,0))))).pow(new Complex(6,0)))
				.times((phi.pow(n.plus(new Complex(2,0))).minus(tau.pow(n.plus(new Complex(2,0))))).pow(new Complex(15,0)))
				.times((phi.pow(n.plus(new Complex(3,0))).minus(tau.pow(n.plus(new Complex(3,0))))).pow(new Complex(20,0)))
				.times((phi.pow(n.plus(new Complex(4,0))).minus(tau.pow(n.plus(new Complex(4,0))))).pow(new Complex(15,0)))
				.times((phi.pow(n.plus(new Complex(5,0))).minus(tau.pow(n.plus(new Complex(5,0))))).pow(new Complex(6,0)))
				.times(phi.pow(n.plus(new Complex(6,0))).minus(tau.pow(n.plus(new Complex(6,0)))))
				);
	}
	public static void main(String[] basiq) {
		for(int i=0;i<6;i++) {
			System.out.println(multipleFormula4(new Complex(i,0)));
		}
	}
	
}
