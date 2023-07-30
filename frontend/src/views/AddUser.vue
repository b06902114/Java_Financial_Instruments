<!--No Usage-->>

<template> 
    <main>
        <Navbar/>
        <div class="my-5">
            <div class="mx-auto w-25" style="max-width: 100%;">
                <h2 class="text-center mb-3">Add User</h2>
                <form @submit.prevent="addUser">
                     <!--ID-->
                     <div class="row">
                        <div class="col-md-12 form-group mp-3">
                            <label for="ID" class="form-label">ID</label>
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
                     <!--email-->
                     <div class="row">
                        <div class="col-md-12 form-group mp-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="text" name="email" id="email" class="form-control" placeholder="Email" required v-model="user.email">
                        </div>
                    </div>
                     <!--account-->
                     <div class="row">
                        <div class="col-md-12 form-group mp-3">
                            <label for="account" class="form-label">Account</label>
                            <input type="text" name="account" id="account" class="form-control" placeholder="account" required v-model="user.account">
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12 form-group">
                            <input type="submit" value="Submit" class="btn btn-primary w-100">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </main>
</template>

<script>
import Navbar from '../components/Navbar.vue';

export default {
    name: 'AddUser',
    components: {
        Navbar
    },

    data() {
        return {
            user: {
                id: null,
                name: null,
                email: null,
                account: null
            }
        }
    },

    methods: {
        addUser(){
            fetch('http://localhost:9000/add_user', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.user)
            })
            .then(data => {
                //console.log(data)
                //alert(data.message)
                this.$router.push("/")
            })
        }
    }
}

</script>