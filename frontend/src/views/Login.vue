<template>
    <main>

        <LoginComponments/>
        <div class="my-5">
            <div class="mx-auto w-25" style="max-width: 100;">
                <h2 class="text-center mb-3">Login Page</h2>
                <form @submit.prevent="Login">
                    <!--ID-->
                    <div class="row">
                        <div class="col-md-12 form-group mp-3">
                            <label for="id" class="form-label">ID 身分證</label>
                            <input type="text" name="ID" id="ID" class="form-control" placeholder="ID" required v-model="user.id">
                        </div>
                    </div>
                    <!--name-->
                   <div class="row">
                        <div class="col-md-12 form-group mp-3">
                            <label for="name" class="form-label">Name</label>
                            <input type="text" name="name" id="name" class="form-control" placeholder="Name" required v-model="user.name">
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12 form-group">
                            <input type="submit" value="Submit" class="btn btn-primary w-100">
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-md-12 form-group">
                            <button class="btn btn-primary w-100" @click="$event => Register()">Register If not Done Before</button>
                        </div>
                    </div>


                </form>
            </div>

        </div>
    </main>
</template>

<script>
    import LoginComponments from '../components/LoginComponments.vue';
    //import Navbar from '../components/Navbar.vue';
    export default {
        name: 'Login',
        components: {
            //Navbar
            LoginComponments
        },
        data(){
            return {
                user: {
                    id: '',
                    name: '',
                    email: '',
                    account: ''
                }
            }
        },
        methods: {
            Login(){ 
                var User_ID = this.user.id.toUpperCase()
                var User_Name = this.user.name
                fetch(`http://localhost:9000/user/${User_ID}`)
                .then(response => { return response.json();})
                .then(responseData => {
                    //console.log(responseData);
                    this.user = responseData;
                    if(responseData.message == "No value present" || this.user.name.toUpperCase() != User_Name){
                        alert('Login Failed, Try Again Or Register First')
                        this.user.name = User_Name
                        this.user.id = User_ID
                        this.$router.push(`/`)
                    }
                    else{   
                        alert("Login Successfully")
                        this.user.id = this.user.id.toUpperCase()
                        this.$router.push(`/home/menu/${this.user.id}`)
                        
                    }
                })
                .catch(err => {
                    console.log("err")
                    alert('Login Failed')
                })
            
            },
            Register() {
                this.$router.push(`/RegisterPage`)
            }
        },

        beforeMount(){

        }
    }

   

   


</script>