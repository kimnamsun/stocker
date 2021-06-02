package common.mail;

public class Emailer {
	public String email = "";

	public Emailer(String email) {
		this.email = email;
	}

	public void sendMail(EmailDto dto) {

		if (dto.getMailTo() != null && dto.getMailTo().length() > 0) {

			GMail.send(dto.getMailTo(), dto.getTitle(), dto.getContent());
		}
	}
}