app.controller("Ctrlathotities", function ($scope, $http) {
    $scope.roles = [];
    $scope.admins = [];
    $scope.athorities = [];


    $scope.getAllRole = function () {
	
        $http.get("/rest/role").then(resp => {
            $scope.roles = resp.data;
            $scope.roles.forEach(role => {
                console.log(role)
            })
        });

        $http.get("/rest/user?admin=true").then(resp => {
            $scope.admins = resp.data;
        })

        $http.get("/rest/athoritities?admin=true").then(resp => {
            $scope.athorities = resp.data;
        }).catch(error => {
            $location.path("/unauthorized")
            console.log(error)
        })

    }
    $scope.getAllRole();





    $scope.authority_of = function (acc, role) {
        if ($scope.athorities) {
            return $scope.athorities.find(
                ur => ur.user.acount == acc.acount && ur.role.id == role.id
            )
        }
    }


    $scope.authoritiesChanged = function (acc, role) {
        var athority = $scope.authority_of(acc, role);
        if (athority) { // đã cấp quyền
            $scope.delete(athority);

        } else {
            athority = { user: acc, role: role };
            $scope.create(athority);

        }
    }
    // thêm quyền
    $scope.create = function (athority) {
        $http.post('/rest/athoritities', athority).then(resp => {
            $scope.athorities.push(resp.data);
            alert('cấp quyền thành công')
        }).catch(error => {
            alert('cấp quyền lỗi')
            console.log('lỗi', error)
        })
    }
    // xóa quyền 

    $scope.delete = function (athority) {
        console.log('đây là id ', athority.id)

        $http.delete('/rest/athoritities/' + athority.id).then(resp => {
            var index = $scope.athorities.findIndex(
                a => a.id = athority.id
            )
            $scope.athorities.splice(index, 1);
            $scope.athorities.push(resp.data);
            alert('xóa quyền thành công')
        }).catch(error => {
            alert('thu hồi quyền thất bại')
            console.log(error)
        })
    }







});