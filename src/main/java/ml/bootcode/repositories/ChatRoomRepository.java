/**
 * 
 */
package ml.bootcode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ml.bootcode.models.ChatRoom;

/**
 * @author sunnyb
 *
 */
@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

}
