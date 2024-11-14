package upc.edu.ecomovil.api.IAM.infrastructure.hashing.bcrypt;


import org.springframework.security.crypto.password.PasswordEncoder;
import upc.edu.ecomovil.api.IAM.application.internal.outboundservices.hashing.HashingService;

/**
 * This interface is a marker interface for the BCrypt hashing service.
 * It extends the {@link HashingService} and {@link PasswordEncoder} interfaces.
 * This interface is used to inject the BCrypt hashing service in the {@link } class.
 */
public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
