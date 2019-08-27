let createRedirector = () => {

    const navigateLoosingChanceToComeBack = (newUrl) => {
        window.location.replace(newUrl);
    };

    return {navigateWithoutBackOption: navigateLoosingChanceToComeBack}
};

export {createRedirector};