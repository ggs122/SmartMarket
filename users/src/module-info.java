import br.com.users.CreateUsersImpl;
import br.com.usersinterface.UsersInterface;

module users {

    requires usersinterface;

    provides UsersInterface with CreateUsersImpl;
}