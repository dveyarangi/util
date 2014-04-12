package yarangi.resources;

import java.io.IOException;
import java.io.InputStream;

import com.spinn3r.log5j.Logger;

public interface IResource
{
	public boolean validate(Logger log);
	
	public InputStream asStream() throws IOException;
	
//	public R asObject();
}
