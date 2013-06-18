package yarangi.physics;

import yarangi.math.Vector2D;
import yarangi.spatial.Area;

public class Body
{
	
	private Vector2D force = Vector2D.ZERO();
	private Vector2D velocity = Vector2D.ZERO();
	private double mass = 1;
	private double maxSpeedSquare = 1;
	private double maxSpeed;
	private double rotationVelocity = 0;
	
	private double frictionCoef = 0;
	
	private boolean isInert = true;
	
	public Body() 
	{
	}
	public Body(double mass, double maxSpeed) 
	{
		this.mass = mass;
		this.maxSpeed = maxSpeed;
		this.maxSpeedSquare = maxSpeed*maxSpeed;
	}
	
	public void setInert(boolean isInert) { this.isInert = isInert; }
	
	final public Vector2D getVelocity() {	return velocity; }

	final public Vector2D getForce() { return force; }

	final public double getMass() { return mass; }
	
	final public void setMass(double mass) { this.mass = mass; }
	
	final public void moveMassCenter(Area area, double dx, double dy)
	{
		area.translate(dx, dy);
	}
	
	final public void setForce(double x, double y)
	{
		force.setxy(x, y);
	}
	final public void setForce(Vector2D force)
	{
		this.force.setxy(force.x(), force.y());
	}
/*	final public void setVelocity(double x, double y)
	{
		velocity.x = x;
		velocity.y = y;
	}*/
	
	final public void setFrictionCoef(double coef) {
		this.frictionCoef = coef;
	}
	
	final public double getFrictionCoef() { return frictionCoef; }
	
	final public void setRotationVelocity(double rv) {
		this.rotationVelocity = rv;
	}
	
	final public double getRotationVelocity() { return rotationVelocity; }
	
	final public void addForce(Vector2D force)
	{
		this.force.add(force.x(), force.y());
	}
	final public void addForce(double x, double y)
	{
		force.add(x, y);
	}
	
	final public void setVelocity(double x, double y) 
	{
		velocity.setxy( x, y );
		double abs = velocity.x() * velocity.x() + velocity.y()*velocity.y();
		if(abs > getMaxSpeedSquare())
			velocity.multiply(getMaxSpeedSquare()/abs);
	}
	final public void setVelocity(Vector2D v)
	{
		setVelocity( v.x(), v.y() );
	}
	
	final public void addVelocity(double x, double y)
	{
		velocity.add(x, y);
//		double abs = velocity.abs(); // TODO: to many roots here
		double abs = velocity.x() * velocity.x() + velocity.y()*velocity.y();
		if(abs > getMaxSpeedSquare())
			velocity.multiply(getMaxSpeedSquare()/abs);
	}
	final public void addVelocity(Vector2D v)
	{
		addVelocity( v.x(), v.y());
	}

	public final double getMaxSpeedSquare() { return maxSpeedSquare; }
	public final double getMaxSpeed() { return maxSpeed; }
	public final void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
		this.maxSpeedSquare = maxSpeed*maxSpeed; 
	}
	
	public final boolean isInert() { return isInert; }
}
