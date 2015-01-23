var loadData = {
	performAction : function(url) {
		$.ajax({
			url : url,
			success : function(data) {
				$("#data").html(data);
			}
		});
	}
};