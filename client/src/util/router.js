export const router = {

    getUrl () {

        const url = window.location.hash;

        if (url === `#` || url === ``) {

            window.location.hash = `department`;

        }

        return url.split(`?`)[0];

    }
};