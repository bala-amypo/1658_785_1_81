import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public boolean isTokenValid(String token, String username) {
    try {
        String extractedUsername = extractUsername(token);
        return extractedUsername.equals(username) && !isTokenExpired(token);
    } catch (Exception e) {
        return false;
    }
}

private boolean isTokenExpired(String token) {
    Date expiration = parseToken(token).getExpiration();
    return expiration.before(new Date());
}

public String generateTokenForUser(com.example.demo.entity.User user) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("userId", user.getId());
    claims.put("email", user.getEmail());
    claims.put("role", user.getRole());

    return generateToken(claims, user.getEmail());
}
