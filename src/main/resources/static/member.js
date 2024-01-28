function showUpdateForm(memberId, username, password) {
    console.log('memberId: ' + memberId);
    console.log('username: ' + username);
    document.getElementById('updateMemberId').value = memberId;
    document.getElementById('updateUsername').value = username;
    document.getElementById('updatePassword').value = password;
    document.getElementById('updateForm').style.display = 'block';
}

function deleteMember(memberId) {
    if (!confirm('회원을 삭제하시겠습니까?')) {
        return;
    }
    window.location.href = '/member/delete/' + memberId;
}
