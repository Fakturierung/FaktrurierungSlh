package aop;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;

@Duration
@Interceptor
@Priority(2500)
public class PerformanzInterceptor {

	@Inject
	Logger logger;

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		final long startTime = System.currentTimeMillis();
		Object o = ic.proceed();
		final long endTime = System.currentTimeMillis();
		final long duration = (endTime - startTime);
		String method = ic.getMethod().getName();
		logger.info("--- Profiled CALL '{}' in '{}' ms ---", new Object[] { method, duration });
		return o;
	}

}
