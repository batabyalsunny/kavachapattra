/**
 * 
 */
package ml.bootcode.utils;

import java.util.Optional;

import org.springframework.stereotype.Component;

/**
 * @author sunnyb
 *
 */
@Component
public class EntityValidator<E> {

	public E validate(Optional<E> entityOptional) {

		if (!entityOptional.isPresent()) {
//			throw new ApiException("Entity not found");
		}

		return entityOptional.get();
	}
}
