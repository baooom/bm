
public class LinearEquation {
	private double _a,_b,_c,_d,_e,_f;
	public LinearEquation(double a,double b,double c,double d,double e,double f)
	{
		_a=a;
		_b=b;
		_c=c;
		_d=d;
		_e=e;
		_f=f;
	}
	public double get_b() {
		return _b;
	}
	public void set_b(double _b) {
		this._b = _b;
	}
	public double get_a() {
		return _a;
	}
	public void set_a(double _a) {
		this._a = _a;
	}
	public double get_c() {
		return _c;
	}
	public void set_c(double _c) {
		this._c = _c;
	}
	public double get_d() {
		return _d;
	}
	public void set_d(double _d) {
		this._d = _d;
	}
	public double get_e() {
		return _e;
	}
	public void set_e(double _e) {
		this._e = _e;
	}
	public double get_f() {
		return _f;
	}
	public void set_f(double _f) {
		this._f = _f;
	}
	public boolean isSolvable()
	{
		return _a*_d-_b*_c!=0;
	}
	public double getX()
	{
		return (_e*_d-_b*_f)/(_a*_d-_b*_c);
	}
	public double getY()
	{
		return (_a*_f-_e*_c)/(_a*_d-_b*_c);
	}
}
