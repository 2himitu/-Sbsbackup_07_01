<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="아이디 찾기" />

<%@ include file="../common/head.jspf"%>

<script>
let MemberFindLogin__submitFormDone = false;
function MemberFindLogin__submitForm(form) {
	if ( MemberFindLogin__submitFormDone ) {
		return;
	}
	form.name.value = form.name.value.trim();
	
	if ( form.name.value.length == 0 ) {
		alert('이름을 입력해주세요.');
		form.name.focus();
		
		return;
	}
	form.email.value = form.email.value.trim();
	
	if ( form.email.value.length ==0 ) {
		alert('이메일을 입력해주세요.');
		form.email.focus();
		
		return;
	}
	form.submit();
	MemberFindLoginId__submitFormDone = true;
}
</script>

<section class="mt-5">
  <div class="container mx-auto px-3">
    <form class="table-box-type-1" method="POST"
      action="../member/doFindLoginId">
      <input type="hidden" name="afterLoginUri"
        value="${param.afterLoginUri}" />
      <table>
        <colgroup>
          <col width="200" />
        </colgroup>
        <tbody>
          <tr>
            <th>이름</th>
            <td>
              <input autofocus="autofocus" name="name" class="w-96 input input-bordered"
                type="text" placeholder="이름을 입력해주세요." />
            </td>
          </tr>
          <tr>
            <th>이메일</th>
            <td>
              <input name="email" class="w-96 input input-bordered"
                type="email" placeholder="이메일을 입력해주세요." />
            </td>
          </tr>

          <tr>
            <th>아이디 찾기</th>
            <td>
              <button type="submit" class="btn btn-primary">아이디 찾기</button>
              <button type="button"
                class="btn btn-outline btn-secondary"
                onclick="history.back();">뒤로가기</button>
            </td>
          </tr>
          <a type="submit" href="../member/findLoginId"
            class="btn btn-link btn-sm mb-1">
            &nbsp;
            <span>아이디 찾기</span>
          </a>
          <a type="submit" href="../member/join"
            class="btn btn-link btn-sm mb-1">
            &nbsp;
            <span>회원가입</span>
          </a>
          <a type="submit" href="../member/findLoginPw""
            class="btn btn-link btn-sm mb-1">
            &nbsp;
            <span>비밀번호 찾기</span>
          </a>
        </tbody>
      </table>
    </form>
  </div>
</section>

<%@ include file="../common/foot.jspf"%>