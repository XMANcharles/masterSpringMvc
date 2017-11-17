/*
 * Copyright (C), 1995-2017, 没钱有限公司
 * FileName: ProfileForm
 * Author:   Neo Geng
 * Date:     2017/10/26 19:00
 * Description: DTO(Data Transfer Object)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterSpringMvc.profile;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈DTO(Data Transfer Object)〉
 *
 * @author Neo Geng
 *         Date 2017/10/26
 * @since 1.0.0
 */
public class ProfileForm {

    @Size(min = 2)
    private String twitterHandle;

    @Email
    @NotEmpty
    private String email;

    @NotNull
    private LocalDate birthDate;

    @NotEmpty
    private List<String> tastes = new ArrayList<>();

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getTastes() {
        return tastes;
    }

    public void setTastes(List<String> tastes) {
        this.tastes = tastes;
    }
}
