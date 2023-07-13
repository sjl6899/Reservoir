import axios from 'axios'

var valid_map = []
var username=[]
axios.post("http://localhost:8089/user/select")
.then((res) => {
    username=res.data
   for(var i=0;i<username.length;i++){
    valid_map[i]=username[i].username
   }
   console.log(valid_map);
})
export function validUsername(str) {
   return valid_map.indexOf(str.trim()) >= 0 
}